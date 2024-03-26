import {useEffect, useState} from "react";
import {NavLink} from "react-router-dom";
import {
    Alert,
    Chip,
    Dialog,
    DialogContent,
    DialogTitle,
    Stack,
    Table,
    TableBody,
    TableCell,
    TableHead,
    TableRow,
    Typography
} from "@mui/material";
import {getTickets, Ticket} from "../api.ts";
import Button from "@mui/material/Button";
import QRCode from "react-qr-code";
import {Refresh} from "@mui/icons-material";

type TicketsProps = {
    token: string | undefined
}

function Tickets(props: TicketsProps) {
    const [alert, setAlert] = useState<Element | string>("")
    const [currentTicket, setCurrentTicket] = useState<undefined | Ticket>(undefined)
    const [tickets, setTickets] = useState<Ticket[]>([])

    function fetchTickets() {
        if (props.token) {
            setAlert(<Alert severity={"info"}>Getting tickets...</Alert>)
            getTickets(props.token)
                .then(data => {
                    setTickets(data)
                    setAlert(undefined)
                })
                .catch(error => {
                    console.log(error)
                    setAlert(<Alert severity={"error"}>Failed to get tickets</Alert>)
                })
        }
    }

    useEffect(() => {
        fetchTickets()
    }, []);

    return (
        <>
            <h1>Tickets</h1>
            {props.token ? (
                <>
                    {alert}
                    <Button variant={"outlined"} startIcon={<Refresh/>} onClick={fetchTickets}>Refresh</Button>
                    <Table stickyHeader>
                        <TableHead>
                            <TableRow>
                                <TableCell>Datum</TableCell>
                                <TableCell>Gültig von</TableCell>
                                <TableCell>Gültig bis</TableCell>
                                <TableCell>Inhalt</TableCell>
                                <TableCell></TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {tickets.map(ticket => (
                                <TableRow key={ticket.id}>
                                    <TableCell>{ticket.validFrom.toLocaleDateString()}</TableCell>
                                    <TableCell>{ticket.validFrom.toLocaleTimeString()}</TableCell>
                                    <TableCell>{ticket.validTo.toLocaleTimeString()}</TableCell>
                                    <TableCell>
                                        <Stack direction={"row"} spacing={1}>
                                            {Object.keys(ticket.orderContent).map((value) => (
                                                <Chip key={value}
                                                      label={ticket.orderContent[value] + "x " + value}/>
                                            ))}
                                        </Stack>
                                    </TableCell>
                                    <TableCell>
                                        <Button variant={"outlined"}
                                                onClick={() => setCurrentTicket(ticket)}>DETAILS</Button>
                                    </TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                    {
                        currentTicket ? (
                            <Dialog open={!!currentTicket} onClose={() => setCurrentTicket(undefined)} fullWidth>
                                <DialogTitle>Ticket
                                    für {currentTicket?.validFrom.toLocaleDateString()}</DialogTitle>
                                <DialogContent>
                                    <Typography>Von: {currentTicket.validFrom.toLocaleTimeString()} bis: {currentTicket.validTo.toLocaleTimeString()}</Typography>
                                    <Typography>Preis: {currentTicket.prize} CHF</Typography>
                                    <Stack direction={"row"} spacing={1}>
                                        {Object.keys(currentTicket.orderContent).map((value) => (
                                            <Chip key={value}
                                                  label={currentTicket.orderContent[value] + "x " + value}/>
                                        ))}
                                    </Stack>
                                    <br/>
                                    <QRCode
                                        style={{height: "auto", maxWidth: "100%", width: "100%"}}
                                        value={currentTicket.id}
                                        viewBox={`0 0 256 256`}
                                    />
                                </DialogContent>
                            </Dialog>
                        ) : ""
                    }
                </>
            ) : (
                <Alert severity={"warning"}>Log in to create and see your Tickets <NavLink to={"/signin"}>Sign
                    in</NavLink></Alert>
            )}
        </>
    )
}

export default Tickets;