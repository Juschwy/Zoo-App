import ReactDOM from "react-dom/client"
import './index.css'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import App from "./App.tsx";
import AboutUs from "./components/AboutUs.tsx";
import Tickets from "./components/Tickets.tsx";
import AppBar from "./components/AppBar.tsx";
import Footer from "./components/Footer.tsx";
import DPI from "./components/DPI.tsx";
import Datenschutzerklaerung from "./components/Datenschutzerklaerung.tsx";

ReactDOM.createRoot(document.getElementById('root')!).render(
    <BrowserRouter>
        <AppBar />
        <Routes>
            <Route path="/" element={<App />} />
            <Route path="/aboutUs" element={<AboutUs />} />
            <Route path="/tickets" element={<Tickets />} />
            <Route path="/data" element={<DPI />} />
            <Route path="/datenschutzerklaerung" element={<Datenschutzerklaerung />} />
        </Routes>
        <Footer />
    </BrowserRouter>
);