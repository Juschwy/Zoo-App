import React from "react";
import {Link, useNavigate} from "react-router-dom";
import {AppBar, Avatar, Box, Container, IconButton, Menu, MenuItem, Toolbar, Tooltip, Typography} from "@mui/material";
import MenuIcon from "@mui/icons-material/Menu";
import Button from "@mui/material/Button";
import '../App.css'
import {User} from "../api.ts";

type AppBarProps = {
    user: User | undefined,
    signOut: () => void
}

const pages = [
    {name: 'Home', path: '/'},
    {name: 'About Us', path: '/aboutUs'},
    {name: 'Tickets', path: '/tickets'}
];

export default function Header(props: AppBarProps) {
    const [anchorElNav, setAnchorElNav] = React.useState<null | HTMLElement>(null);
    const [anchorElUser, setAnchorElUser] = React.useState<null | HTMLElement>(null);
    const navigate = useNavigate()

    const handleOpenNavMenu = (event: React.MouseEvent<HTMLElement>) => {
        setAnchorElNav(event.currentTarget);
    };
    const handleOpenUserMenu = (event: React.MouseEvent<HTMLElement>) => {
        setAnchorElUser(event.currentTarget);
    };

    const handleCloseNavMenu = () => {
        setAnchorElNav(null);
    };

    const handleCloseUserMenu = () => {
        setAnchorElUser(null);
    };

    return (
        <AppBar position={"fixed"} sx={{"background-color": "#08b411"}}>
            <Container maxWidth="xl">
                <Toolbar disableGutters>
                    <Typography
                        variant="h6"
                        noWrap
                        component={Link}
                        to="/"
                        sx={{
                            mr: 2,
                            display: {xs: 'none', md: 'flex'},
                            fontFamily: 'monospace',
                            fontWeight: 700,
                            letterSpacing: '.3rem',
                            color: 'inherit',
                            textDecoration: 'none',
                        }}
                    >
                        ZOO ZÜRICH
                    </Typography>

                    <Box sx={{flexGrow: 1, display: {xs: 'flex', md: 'none'}}}>
                        <IconButton
                            size="large"
                            aria-label="account of current user"
                            aria-controls="menu-appbar"
                            aria-haspopup="true"
                            onClick={handleOpenNavMenu}
                            color="inherit"
                        >
                            <MenuIcon/>
                        </IconButton>
                        <Menu
                            id="menu-appbar"
                            anchorEl={anchorElNav}
                            anchorOrigin={{
                                vertical: 'bottom',
                                horizontal: 'left',
                            }}
                            keepMounted
                            transformOrigin={{
                                vertical: 'top',
                                horizontal: 'left',
                            }}
                            open={Boolean(anchorElNav)}
                            onClose={handleCloseNavMenu}
                            sx={{
                                display: {xs: 'block', md: 'none'},
                            }}
                        >
                            {pages.map((page: any) => (
                                <MenuItem key={page.name} onClick={handleCloseNavMenu} component={Link} to={page.path}>
                                    <Typography textAlign="center">{page.name}</Typography>
                                </MenuItem>
                            ))}
                        </Menu>
                    </Box>

                    <Box sx={{flexGrow: 1, display: {xs: 'none', md: 'flex'}}}>
                        {pages.map((page: any) => (
                            <Button
                                key={page.name}
                                component={Link}
                                to={page.path}
                                sx={{my: 2, color: 'white', display: 'block'}}
                                onClick={handleCloseNavMenu}
                            >
                                {page.name}
                            </Button>
                        ))}
                    </Box>

                    <Box sx={{flexGrow: 0}}>
                        <Tooltip title="Open settings">
                            <IconButton onClick={handleOpenUserMenu} sx={{p: 0}}>
                                {props.user ? (
                                    <Avatar>{props.user.firstname.charAt(0) + props.user.lastname.charAt(0)}</Avatar>
                                ) : (
                                    <Avatar/>
                                )}

                            </IconButton>
                        </Tooltip>
                        <Menu
                            sx={{mt: '45px'}}
                            id="menu-appbar"
                            anchorEl={anchorElUser}
                            anchorOrigin={{
                                vertical: 'top',
                                horizontal: 'right',
                            }}
                            keepMounted
                            transformOrigin={{
                                vertical: 'top',
                                horizontal: 'right',
                            }}
                            open={Boolean(anchorElUser)}
                            onClose={handleCloseUserMenu}
                        >
                            {props.user ? (
                                <>
                                    <MenuItem>
                                        <Typography textAlign="center">{props.user.firstname} {props.user.lastname}</Typography>
                                    </MenuItem>
                                    <MenuItem>
                                        <Typography textAlign="center">{props.user.username}</Typography>
                                    </MenuItem>
                                    <MenuItem onClick={props.signOut}>
                                        <Typography textAlign="center">Sign out</Typography>
                                    </MenuItem>
                                </>
                            ) : (
                                <>
                                    <MenuItem onClick={() => navigate("/signin")}>
                                        <Typography textAlign="center">Sign in</Typography>
                                    </MenuItem>
                                    <MenuItem onClick={() => navigate("/signup")}>
                                        <Typography textAlign="center">Sign up</Typography>
                                    </MenuItem>
                                </>
                            )}
                        </Menu>
                    </Box>
                </Toolbar>
            </Container>
        </AppBar>
    );
}
