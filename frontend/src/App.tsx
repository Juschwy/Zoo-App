import {
    createTicket,
    createUser,
    getTicket,
    getTicketCategories,
    getTicketCategory,
    getTickets,
    getToken
} from "./api.ts";

function App() {
    // eslint-disable-next-line @typescript-eslint/ban-ts-comment
    // @ts-ignore
    window.tx = {getTicket, getTickets, createTicket, getTicketCategories, getTicketCategory, getToken, createUser}

    return (
        <>
            <div className={"title"}>
                <h1>Willkommen zur Website des Zoo Zürichs</h1>
            </div>
        </>
    )
}

export default App
