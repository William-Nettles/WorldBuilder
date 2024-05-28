import { useState } from "react";
import { Container } from "react-bootstrap";
import { CardInterface } from "../../../Interfaces/CardInterface";
import { CardComp } from "../../Builders/Cards";

export const LocationDashboard: React.FC = () => {
    const [builder] = useState<CardInterface>(
        {
            name: "New Location",
            description: "Create a new location",
            image: '/western steppe.png',
            path: "/locations/add"
        });
    const [cardsState, setCardsState] = useState<CardInterface[]>([])


    return (
        <div>
            <Container style={{ color: "white", backgroundColor: "rgba(0,0,0,.65)", borderRadius: '20px', padding: '10px' }}>
                <h1>Location Dashboard</h1>
                <p>Welcome to the Location Dashboard page</p>
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