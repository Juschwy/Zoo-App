import {Dispatch, SetStateAction, useState} from "react";
import {Alert, Box, Container, Grid, TextField, Typography} from "@mui/material";
import Button from "@mui/material/Button";
import {NavLink, useNavigate} from "react-router-dom";
import {getToken, User} from "../api.ts";

type SignInProps = {
    setUser: Dispatch<SetStateAction<User | undefined>>
}

export default function SignIn(props: SignInProps) {
    const [password, setPassword] = useState("")
    const [username, setUsername] = useState("")
    const [alert, setAlert] = useState<any>("")
    const navigate = useNavigate();

    function signin(e: MouseEvent) {
        e.preventDefault()
        setAlert(<Alert severity="info">Logging in...</Alert>)
        getToken(username, password)
            .then(user => {
                props.setUser(user)
                let gotoPage = "/tickets"
                if (user.role == "ADMIN") gotoPage = "/scan-tickets"
                setAlert(<Alert severity="success">Logged in as {user.username}. Redirecting to <NavLink to={gotoPage}>{gotoPage}</NavLink></Alert>)
                setTimeout(() => navigate(gotoPage), 5000)
            })
            .catch(() => setAlert(<Alert severity="error">Password or Email is incorrect</Alert>))
    }


    return (
        <>
            {alert}
            <Container component="main" maxWidth="xs">
                <Box>
                    <Typography component="h1" variant="h5">
                        Sign In
                    </Typography>
                    <Box component="form">
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            id="email"
                            type="email"
                            label="Email Address"
                            autoFocus
                            value={username}
                            onChange={e => setUsername(e.target.value)}
                        />
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            label="Password"
                            type="password"
                            id="password"
                            value={password}
                            onChange={e => setPassword(e.target.value)}
                        />
                        <Button
                            type="submit"
                            fullWidth
                            variant="contained"
                            sx={{mt: 3, mb: 2}}
                            onClick={e => signin(e)}
                        >
                            Sign In
                        </Button>
                        <Grid className="footer">
                            <Typography component="h5">
                                Don't have an account? <NavLink to={"/signup"}>Sign up</NavLink>
                            </Typography>
                        </Grid>
                    </Box>
                </Box>
            </Container>
        </>
    )
}