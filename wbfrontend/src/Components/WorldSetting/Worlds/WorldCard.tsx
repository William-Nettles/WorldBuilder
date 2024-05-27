import { Button, Card, Container } from "react-bootstrap";
import { WorldInterface } from "../../../Interfaces/WorldInterface";
import { useNavigate } from "react-router-dom";

export const WorldCard: React.FC<WorldInterface> = (world: WorldInterface) => {

    const nav = useNavigate();

    return (
    <Card bg="dark" style={{ width: '18rem', color:'white', margin:'5px', position:'relative'}}>
        <Card.Img variant="top" src={world.image} />
        <Card.Body>
            <Card.Title>{world.name}</Card.Title>
            <Card.Text>
                {world.description}
            </Card.Text>
            <Button variant="warning" onClick={()=> nav(`/world/${world.id as number}`)} 
                style={{ position:'absolute', bottom:'5px',left: '50%', transform: 'translateX(-50%)'}}>View</Button>
        </Card.Body>
    </Card>
    );
}