const BASE_URL = "http://localhost:8080"
const TICKETS_URL = BASE_URL + "/tickets"
const TICKETCATEGORIES_URL = BASE_URL + "/ticket-categories"

type Ticket = {
    id: string,
    customerFirstname: string,
    customerLastname: string,
    validFrom: Date,
    validTo: Date,
    orderContent: {string: number},
    idId: string | null,
    prize: number
}

type TicketCategory = {
    name: string,
    prize: number
}

export function getTickets(): Promise<Ticket[]>{
    return fetch(TICKETS_URL, {
        method: "GET"
    })
        .then(res => res.json())
}

export function getTicket(id: string): Promise<Ticket>{
    return fetch(TICKETS_URL + "/" + id, {
        method: "GET"
    })
        .then(res => res.json())
}

export function createTicket(customerFirstname: string, customerLastname: string, validFrom: Date, validTo: Date, orderContent: {
    string: number
}, idId: string): Promise<Ticket> {
    return fetch(TICKETS_URL, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            customerFirstname,
            customerLastname,
            validFrom,
            validTo,
            orderContent,
            idId
        })
    })
        .then(res => res.json())
}

export function getTicketCategories(): Promise<TicketCategory[]>{
    return fetch(TICKETCATEGORIES_URL, {
        method: "GET"
    })
        .then(res => res.json())
}

export function getTicketCategory(name: string): Promise<TicketCategory>{
    return fetch(TICKETCATEGORIES_URL + "/" + name, {
        method: "GET"
    })
        .then(res => res.json())
}