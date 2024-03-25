import {createTicket, getTicket, getTickets} from "./api.ts";
import MainPage from "./components/MainPage";

function App() {
    window.tx = {getTicket, getTickets, createTicket}

    return (
        <>
            <div className={"title"}>
                <h1>Willkommen zur Website des Zoo Zürichs</h1>
                <MainPage />
            </div>
        </>
    )
}

export default App
