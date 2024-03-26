import {NavLink} from "react-router-dom";

function Footer() {
    return (
        <footer>
            <NavLink to={"/datenschutz"}>Datenschutz</NavLink> <NavLink to={"/impressum"}>Impressum</NavLink>
        </footer>
    );
}

export default Footer;