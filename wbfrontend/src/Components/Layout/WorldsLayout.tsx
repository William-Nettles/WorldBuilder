import { Container } from "react-bootstrap"
import { WorldNavbar } from "../Navigaton/WorldNavbar";
import { Outlet } from "react-router-dom";
export const WorldsLayout: React.FC<any> = () => {

    return (
        <>
            <WorldNavbar />
            <Container className="d-flex flex-column justify-content-center m-5 px-5 pt-2" style={{backgroundImage: 'C:/Users/Willn/Documents/Projects/Personal/WorldBuilder/wbfrontend/public/worlds splash.png'}}>
                <Container className="w-75 p-3">
                    <Outlet />
                </Container>
            </Container>
        </>
    );
};