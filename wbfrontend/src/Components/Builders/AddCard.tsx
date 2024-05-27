import './AddCard.css';
import { useNavigate } from "react-router-dom";
import { AddCardInterface } from "../../Interfaces/AddCardInterface";
import { Button, Card, Container } from "react-bootstrap";

export const AddCard: React.FC<AddCardInterface> = (card:AddCardInterface) => {

    const nav = useNavigate();

    return (
        <Card bg="dark" style={{ width: '18rem', color:'white', margin:'5px'}}>
            <div className='image-container'>
                <Card.Img variant="top" src={card.image} />
            </div>
        <Card.Body>
            <Card.Title>{card.name}</Card.Title>
            <Card.Text className='card-text'>
                {card.description}
            </Card.Text>
            <Button variant="warning" onClick={()=> nav(card.path)} >New</Button>
        </Card.Body>
    </Card>
    );
}