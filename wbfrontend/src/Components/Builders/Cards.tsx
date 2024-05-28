import './AddCard.css';
import { useNavigate } from "react-router-dom";
import { CardInterface } from "../../Interfaces/CardInterface";
import { Button, Card, Container } from "react-bootstrap";
import { useEffect } from 'react';

export const CardComp: React.FC<CardInterface> = (card: CardInterface) => {

    const nav = useNavigate();

    return (
        <Card bg="dark" style={{ width: '18rem', color: 'white', margin: '5px' }}>
            <div className={card.name.startsWith('New') ? 'image-container':''}>
                <Card.Img variant="top" src={card.image} />
            </div>
            <Card.Body>
                <Card.Title>{card.name}</Card.Title>
                <Card.Text className='card-text'>
                    {card.description}
                </Card.Text>
                <Button variant="warning" onClick={() => nav(card.path)} >{card.name.startsWith('New') ? 'New':'View'}</Button>
            </Card.Body>
        </Card>
    );
}