import { useParams } from "react-router-dom";
import { WorldInterface } from "../../../Interfaces/WorldInterface";
import { useEffect, useState } from "react";
import { get } from "http";
import { getWorld } from "../../../Global/apis";
import { Container } from "react-bootstrap";


export const WorldDetails: React.FC = () => {

    
    const {worldId} = useParams();
    
    const [world, setWorld] = useState<WorldInterface>();

    useEffect(() => {
        async function fetchData() {
            setWorld(await getWorld(worldId as unknown as number));
        }
        fetchData();
    }, [worldId]);


    return (
        <Container style={{color:'white', backgroundColor:"rgba(0,0,0,.65)", borderRadius:'20px', padding: '10px'}}>
        <h1>{world?.name}</h1>
            <p>{world?.description}</p>
        </Container>
    );
}