import { useState } from "react";
import { Container } from "react-bootstrap";
import { CardInterface } from "../../../Interfaces/CardInterface";
import { CardComp } from "../../Builders/Cards";

export const FactionDashboard: React.FC = () => {

    const [builder] = useState<CardInterface>(
        {
            name: "New Faction",
            description: "Create a new faction",
            image: '/kriarch.png',
            path: "/factions/add"
        });
    const [cardsState, setCardsState] = useState<CardInterface[]>([])


    return (
        <div>
            <Container style={{ color: "white", backgroundColor: "rgba(0,0,0,.65)", borderRadius: '20px', padding: '10px' }}>
                <h1>Faction Dashboard</h1>
                <p>Welcome to the Faction Dashboard page</p>
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