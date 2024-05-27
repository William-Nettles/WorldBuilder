import { Container } from "react-bootstrap";

export const CharacterDashboard: React.FC = () => {
    return (
        <Container style={{color: "white", backgroundColor:"rgba(0,0,0,.65)", borderRadius:'20px', padding: '10px'}}>
        <h1>CharacterDashboard</h1>
            <p>Welcome to the CharacterDashboard page</p>
        </Container>
    );
}