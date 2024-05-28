import { useState } from "react";
import { Container } from "react-bootstrap";
import { CardInterface } from "../../../Interfaces/CardInterface";
import { CardComp } from "../../Builders/Cards";

export const EventsDashboard: React.FC = () => {
    const [builder] = useState<CardInterface>(
        {
            name: "New Event",
            description: "Create a new event",
            image: '/dreams.png',
            path: "/maps/add"
        });
    const [cardsState, setCardsState] = useState<CardInterface[]>([])


    return (
        <div>
            <Container style={{ color: "white", backgroundColor: "rgba(0,0,0,.65)", borderRadius: '20px', padding: '10px' }}>
                <h1>Event Dashboard</h1>
                <p>Welcome to the Event Dashboard page</p>
            </Container>
            <div style={{ display: 'flex', flexDirection: "row" }}>
                <CardComp {...builder} />
                {cardsState.map(card => {
                    return (
                        <CardComp {...card} />)
                }
                )}
            </div>
        </div>
    );
}