import { Container } from "react-bootstrap";
import { CardComp } from "../../Builders/Cards";
import { CardInterface } from "../../../Interfaces/CardInterface";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { get } from "http";
import { getCharactersByWorld } from "../../../Global/apis";

export const CharacterDashboard: React.FC = () => {
    const {worldId} = useParams<{worldId: string}>();

    const [builder] = useState<CardInterface>(
        {
            name: "New Character",
            description: "Create a new character",
            image: '/Demien_Price.png',
            path: `/world/${parseInt(worldId as string, 10)}/characters/add`
        });
    const [cardsState, setCardsState] = useState<CardInterface[]>([])

    useEffect(() => {
        const fetchCharacters = async () => {
            const charData = await getCharactersByWorld(parseInt(worldId as string, 10));
            
            setCardsState(charData.map(character => {
                return {name: `${character.firstName} ${character.lastName}` || '', description: character.description || '', image: character.image || '', path: `world/${worldId}/characters/${character.id}`};
            }));
        }
        fetchCharacters();
    }, []);

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