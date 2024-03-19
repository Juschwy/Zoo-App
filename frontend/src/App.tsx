import {createTicket, getTicket, getTickets} from "./api.ts";

function App() {
    window.tx = {getTicket, getTickets, createTicket}

    return (
        <>
            <div className={"title"}>
                <h1>Willkommen zur Website des Zoo Zürichs</h1>
            </div>
        </>
    )
}

export default App
