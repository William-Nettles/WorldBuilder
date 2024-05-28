import { Button, Container, Nav, Navbar, NavDropdown } from "react-bootstrap"
import { useContext, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { UserContext } from "../Contexts/UserContext";

export const NavbarComp: React.FC = () => {

    const { currentUser, setCurrentUser } = useContext(UserContext)
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

    return (
        <Navbar fixed="top" expand="lg" bg="dark" data-bs-theme="dark">
            <Container>
                <Navbar.Brand href="/">World Builder</Navbar.Brand>
                <Navbar.Toggle aria-controls="wolrd-builder-navbar-nav" />
                <Navbar.Collapse id="wolrd-builder-navbar-nav" className="justify-content-end">
                    {currentUser == null ?
                    <Nav>
                        <Nav.Link href="/login">Login</Nav.Link>
                        <Nav.Link href="/register">Register</Nav.Link>
                        <Nav.Link href="/">Home</Nav.Link>
                        <Nav.Link href="/about">about</Nav.Link>
                            
                    </Nav> :
                    <>
                        <Nav>
                            <Nav.Link href="/">Home</Nav.Link>
                            <Nav.Link href="/about">About</Nav.Link>
                            <Nav.Link href="/worlds">Worlds</Nav.Link>
                            <Nav.Link href="/account">{currentUser.username}</Nav.Link>
                            <Button variant="warning" style={{ margin: "5px" }} onClick={logout}>Logout</Button>
                            {currentUser.role?.toUpperCase() === "ADMIN" && <NavDropdown title="ADMIN">
                                <NavDropdown.Item href="/allusers">Users</NavDropdown.Item>
                            </NavDropdown>}                            
                        </Nav>
                        </>}
                </Navbar.Collapse>
            </Container>
        </Navbar>
    )
}
export { Navbar };

