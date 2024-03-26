import {
    createTicket,
    createUser,
    getTicket,
    getTicketCategories,
    getTicketCategory,
    getTickets,
    getToken, User
} from "./api.ts";
import AppBar from "./components/AppBar.tsx";
import {Route, Routes} from "react-router-dom";
import AboutUs from "./pages/AboutUs.tsx";
import Tickets from "./pages/Tickets.tsx";
import Footer from "./components/Footer.tsx";
import Home from "./pages/Home.tsx";
import {useState} from "react";
import SignIn from "./pages/SignIn.tsx";
import SignUp from "./pages/SignUp.tsx";
import {NotFound} from "./pages/NotFound.tsx";

function App() {
    // eslint-disable-next-line @typescript-eslint/ban-ts-comment
    // @ts-ignore
    window.tx = {getTicket, getTickets, createTicket, getTicketCategories, getTicketCategory, getToken, createUser}
    const [user, setUser] = useState<undefined | User>(undefined)

    return (
        <>
            <AppBar/>
            <div id={"content"}>
                <Routes>
                    <Route path={"/"} element={<Home/>}/>
                    <Route path={"*"} element={<NotFound/>}/>
                    <Route path={"/aboutUs"} element={<AboutUs/>}/>
                    <Route path={"/tickets"} element={<Tickets/>}/>
                    <Route path={"/signin"} element={<SignIn setUser={setUser}/>}/>
                    <Route path={"/signup"} element={<SignUp/>}/>
                </Routes>
            </div>
            <Footer/>
        </>
    )
}

export default App
