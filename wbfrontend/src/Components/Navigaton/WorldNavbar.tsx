import { Button, Container, Nav, Navbar, NavDropdown } from "react-bootstrap"
import { useContext, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { UserContext } from "../Contexts/UserContext";
import { useState } from 'react';


export const WorldNavbar: React.FC = () => {

    const { currentUser, setCurrentUser } = useContext(UserContext)
    const { worldId }= useParams();
    const navigate = useNavigate();
    

    const upateNavbar = () => {
        const currentURL = new URL(window.location.href);
        const path = currentURL.pathname;
        const navbarItems = document.querySelectorAll(".nav-link");
        navbarItems.forEach(item => item.classList.remove("active"));
        navbarItems.forEach((item) => {
            if (item.getAttribute("href") === path) {
                item.classList.add("active");
            }
        });
    };

    useEffect(() => {
        const timer = setTimeout(() => {
            upateNavbar();
        }, 100);
        return () => clearTimeout(timer);
    }, []);

    const logout = () => {
        setCurrentUser(null);
        localStorage.removeItem('currentUser');
        navigate("/");
    };



const [isOpen, setIsOpen] = useState(true);

const handleToggle = () => setIsOpen(!isOpen);

return (
    <div>
        <Button variant = "dark" onClick={handleToggle} style={{position: 'fixed', top: 58, left: 0}}>| | |</Button>
        <Navbar style={{position: 'fixed', top: 0, left: 0, height: '100vh', width: isOpen ? '100px' : '0', transition: "width 0.25s", overflow: "hidden", }} expand="lg" bg="dark" data-bs-theme="dark">
            <Container>
                <Button variant = "dark" onClick={handleToggle} style={{position: 'fixed', top: 58, left: 0}}>| | |</Button>
                <Navbar.Toggle onClick={handleToggle} aria-controls="world-builder-navbar-nav" />
                <Navbar.Collapse in={isOpen} id="world-builder-navbar-nav" className="justify-content-evenly" style={{alignItems: 'flex-start'}}>
                    {currentUser == null ?
                    
                    <Nav style={{ textAlign:'left', flexDirection : 'column', opacity: isOpen ? 1 : 0, transition: "opacity 0.25s"}}>
                        <Nav.Link href={`/world/${worldId}`}>Overview</Nav.Link>
                        <Nav.Link href={`/world/${worldId}/characters`}>Characters</Nav.Link>
                        <Nav.Link href={`/world/${worldId}/factions`}>Factions</Nav.Link>
                        <Nav.Link href={`/world/${worldId}/locations`}>Locations</Nav.Link>
                        <Nav.Link href={`/world/${worldId}/events`}>Events</Nav.Link>
                        <Nav.Link href={`/world/${worldId}/maps`}>Maps</Nav.Link>
                        <Nav.Link href={`/world/${worldId}/timeline`}>Timeline</Nav.Link>
                    
                    </Nav> :
                    <>
                        <Nav style={{textAlign:'left', flexDirection : 'column', opacity: isOpen ? 1 : 0, transition: "opacity 0.25s"}}>
                            <Nav.Link href={`/world/${worldId}`}>Overview</Nav.Link>
                            <Nav.Link href={`/world/${worldId}/characters`}>Characters</Nav.Link>
                            <Nav.Link href={`/world/${worldId}/factions`}>Factions</Nav.Link>
                            <Nav.Link href={`/world/${worldId}/locations`}>Locations</Nav.Link>
                            <Nav.Link href={`/world/${worldId}/events`}>Events</Nav.Link>
                            <Nav.Link href={`/world/${worldId}/maps`}>Maps</Nav.Link>
                            <Nav.Link href={`/world/${worldId}/timeline`}>Timeline</Nav.Link>
                            {currentUser.role?.toUpperCase() === "ADMIN" && <NavDropdown title="ADMIN">
                                <NavDropdown.Item href="/allusers">Users</NavDropdown.Item>
                            </NavDropdown>}
                        </Nav>
                    </>}
                </Navbar.Collapse>
            </Container>
        </Navbar>
    </div>
);
}
export { Navbar };

