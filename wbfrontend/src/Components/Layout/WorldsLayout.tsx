import { Container } from "react-bootstrap"
import { WorldNavbar } from "../Navigaton/WorldNavbar";
import { Outlet } from "react-router-dom";
export const WorldsLayout: React.FC<any> = () => {

    return (
        <>
            <WorldNavbar />
            <Container className="d-flex flex-column justify-content-center m-5 px-5 pt-2" >
                <Container className="w-75 p-2">
                    <Outlet />
                </Container>
            </Container>
        </>
    );
};