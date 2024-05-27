import { useEffect, useState } from "react";
import { WorldInterface } from "../../../Interfaces/WorldInterface";
import { WorldCard } from "./WorldCard";
import {getWorlds} from "../../../Global/apis";
import { AddCard } from "../../Builders/AddCard";
import { AddCardInterface } from "../../../Interfaces/AddCardInterface";
import './WorldsDashboard.css';
import { useLocation } from "react-router-dom";

export const WorldsDashboard: React.FC = () => {

    const location = useLocation();
    const [worlds, setWorlds] = useState<WorldInterface[]>([]);
    const [builder] = useState<AddCardInterface>(
        {name:"New World", 
        description:"Create a new world", 
        image:'/newWorld.jpg', 
        path:"/worlds/add"});

    useEffect(() => {
        const fetchWorlds = async () => {
            const worldsData = await getWorlds();
            setWorlds(worldsData);
        };

        fetchWorlds();
    }, []);

    return (
        <div>
        <h1>WorldsDashboard</h1>
            <p>Welcome to the WorldsDashboard page</p>

            {worlds.map(world => {
                return (
                    <div style={{display: 'flex', flexDirection:"row"}}>
                        <AddCard {...builder} />
                        {worlds.map(world =><WorldCard {...world} />)}
                    </div>
                );
            })}
        </div>
    );
}