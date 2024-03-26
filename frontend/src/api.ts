const BASE_URL = "http://localhost:8080"
const TICKETS_URL = BASE_URL + "/tickets"
const TICKETCATEGORIES_URL = BASE_URL + "/ticket-categories"
const USER_URL = BASE_URL + "/users"
const TOKEN_URL = BASE_URL + "/token"

type Ticket = {
    id: string,
    validFrom: Date,
    validTo: Date,
    orderContent: { string: number },
    idId: string | null,
    prize: number
}

export type User = {
    firstname: string,
    lastname: string,
    username: string,
    token: string,
    role: "ADMIN" | "USER"
}

type TicketCategory = {
    name: string,
    prize: number
}

function authorizedFetch(method: "GET" | "POST", path: string, token: string, body: object = {}) {
    return fetch(path, {
        method: method,
        headers: {
            "Authorization": "Bearer " + token,
            "Content-Type": "application/json"
        },
        body: JSON.stringify(body)
    })
        .then(res => res.json())
}

export function getTickets(token: string): Promise<Ticket[]> {
    return authorizedFetch("GET", TICKETS_URL, token)
}

export function getTicket(id: string, token: string): Promise<Ticket> {
    return authorizedFetch("GET", TICKETS_URL + "/" + id, token)
}

export function createTicket(token: string, validFrom: Date, validTo: Date, orderContent: {
    string: number
}, idId: string): Promise<Ticket> {
    return authorizedFetch("POST", TICKETS_URL, token, {
        validFrom,
        validTo,
        orderContent,
        idId
    })
}

export function getTicketCategories(): Promise<TicketCategory[]> {
    return fetch(TICKETCATEGORIES_URL, {
        method: "GET"
    })
        .then(res => res.json())
}

export function getTicketCategory(name: string): Promise<TicketCategory> {
    return fetch(TICKETCATEGORIES_URL + "/" + name, {
        method: "GET"
    })
        .then(res => res.json())
}

export function getToken(username: string, password: string): Promise<User> {
    return fetch(TOKEN_URL, {
        method: "POST",
        headers: {
            "Authorization": "Basic " + btoa(username + ":" + password)
        }
    })
        .then(res => res.json())
}

export function createUser(firstname: string, lastname: string, username: string, password: string) {
    return fetch(USER_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            firstname,
            lastname,
            username,
            password
        })
    })
}