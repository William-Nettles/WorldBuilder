import { Container } from "react-bootstrap";
import { CardComp } from "../../Builders/Cards";
import { CardInterface } from "../../../Interfaces/CardInterface";
import { useState } from "react";

export const CharacterDashboard: React.FC = () => {

    const [builder] = useState<CardInterface>(
        {
            name: "New Character",
            description: "Create a new character",
            image: '/newWorld.jpg',
            path: "/characters/add"
        });
    const [cardsState, setCardsState] = useState<CardInterface[]>([])


    return (
        <div>
            <Container style={{color: "white", backgroundColor:"rgba(0,0,0,.65)", borderRadius:'20px', padding: '10px'}}>
            <h1>Character Dashboard</h1>
                <p>Welcome to the Character Dashboard page</p>        
            </Container>
            <div style={{display: 'flex', flexDirection:"row"}}>
                <CardComp {...builder} />
                {cardsState.map(card => {return (
                    <CardComp {...card} />)}
                )}
            </div>
        </div>
    );
}