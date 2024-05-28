import { useEffect, useState } from "react";
import { WorldInterface } from "../../../Interfaces/WorldInterface";
import {getWorlds} from "../../../Global/apis";
import { CardComp } from "../../Builders/Cards";
import { CardInterface } from "../../../Interfaces/CardInterface";
import './WorldsDashboard.css';

export const WorldsDashboard: React.FC = () => {

    const [, setWorlds] = useState<WorldInterface[]>([]);
    const [builder] = useState<CardInterface>(
        {name:"New World", 
        description:"Create a new world", 
        image:'/newWorld.jpg', 
        path:"/worlds/add"});

    const [cardsState, setCardsState] = useState<CardInterface[]>([])
   

    useEffect(() => {
        const fetchWorlds = async () => {
            const worldsData = await getWorlds();
            setWorlds(worldsData);
            setCardsState(worldsData.map(world => {
                return {name: world.name || '', description: world.description || '', image: world.image || '', path: `/world/${world.id}`};
            }));
        };

        fetchWorlds();
    }, []);

    return (
        <div>
        <h1>WorldsDashboard</h1>
            <p>Welcome to the WorldsDashboard page</p>
            <div style={{display: 'flex', flexDirection:"row"}}>
                <CardComp {...builder} />
                {cardsState.map(card => {return (
                    <CardComp {...card} />)}
                )}
            </div>
        </div>
    );
}