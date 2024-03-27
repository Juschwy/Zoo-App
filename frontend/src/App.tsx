import {
    createTicket,
    createUser,
    getTicket,
    getTicketCategories,
    getTicketCategory,
    getTickets,
    getToken,
    User
} from "./api.ts";
import Header from "./components/Header.tsx";
import {Route, Routes} from "react-router-dom";
import AboutUs from "./pages/AboutUs.tsx";
import Tickets from "./pages/Tickets.tsx";
import Footer from "./components/Footer.tsx";
import Home from "./pages/Home.tsx";
import {useEffect, useState} from "react";
import SignIn from "./pages/SignIn.tsx";
import SignUp from "./pages/SignUp.tsx";
import {NotFound} from "./pages/NotFound.tsx";
import Impressum from "./pages/Impressum.tsx";
import DPI from "./pages/DPI.tsx";

function App() {
    // eslint-disable-next-line @typescript-eslint/ban-ts-comment
    // @ts-ignore
    window.tx = {getTicket, getTickets, createTicket, getTicketCategories, getTicketCategory, getToken, createUser}
    const [user, setUser] = useState<undefined | User>(undefined)

    useEffect(() => {
        if (user) {
            localStorage.setItem("USER", btoa(JSON.stringify(user)))
        }
    }, [user]);

    useEffect(() => {
        const userString = localStorage.getItem("USER")
        try {
            if (!userString) {
                throw Error("No User")
            }
            setUser(JSON.parse(atob(userString)))
        } catch (e) {
            localStorage.removeItem("USER")
        }
    }, []);

    function signOut(){
        setUser(undefined)
    }

    return (
        <>
            <Header user={user} signOut={signOut}/>
            <div id={"content"}>
                <Routes>
                    <Route path={"/"} element={<Home/>}/>
                    <Route path={"*"} element={<NotFound/>}/>
                    <Route path={"/aboutUs"} element={<AboutUs/>}/>
                    <Route path={"/tickets"} element={<Tickets token={user?.token}/>}/>
                    <Route path={"/signin"} element={<SignIn setUser={setUser}/>}/>
                    <Route path={"/signup"} element={<SignUp/>}/>
                    <Route path={"/impressum"} element={<Impressum/>}/>
                    <Route path={"/datenschutz"} element={<DPI/>}/>
                </Routes>
            </div>
            <Footer/>
        </>
    )
}

export default App
