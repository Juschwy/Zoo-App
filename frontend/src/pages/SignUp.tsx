import {useState} from "react";
import {Alert, Box, Container, Grid, TextField, Typography} from "@mui/material";
import Button from "@mui/material/Button";
import {NavLink, useNavigate} from "react-router-dom";
import {createUser} from "../api.ts";

export default function SignUp() {
    const [firstname, setFirstname] = useState("")
    const [lastname, setLastname] = useState("")
    const [password, setPassword] = useState("")
    const [username, setUsername] = useState("")
    // @typescript-eslint/ban-ts-comment
    // @ts-ignore
    const [alert, setAlert] = useState<any>("")
    const navigate = useNavigate();

    function signup(e: MouseEvent) {
        e.preventDefault()
        setAlert(<Alert severity="info">Creating account...</Alert>)
        createUser(firstname, lastname, username, "{noop}" + password)
            .then(() => {
                setAlert(<Alert severity="success">Created account for {username}</Alert>)
                navigate("/signin")
            })
            .catch(() => setAlert(<Alert severity="error">Failed to create account</Alert>))
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
                            id="firstname"
                            type="text"
                            label="Firstname"
                            autoFocus
                            value={firstname}
                            onChange={e => setFirstname(e.target.value)}
                        />
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            id="lastname"
                            type="text"
                            label="Lastname"
                            value={lastname}
                            onChange={e => setLastname(e.target.value)}
                        />
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            id="email"
                            type="email"
                            label="Email Address"
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
                            onClick={e => signup(e)}
                        >
                            Sign Up
                        </Button>
                        <Grid className="footer">
                            <Typography component="h5">
                                Already have an account <NavLink to={"/signin"}>Sign in</NavLink>
                            </Typography>
                        </Grid>
                    </Box>
                </Box>
            </Container>
        </>
    )
}