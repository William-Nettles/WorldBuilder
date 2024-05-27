import axios from "axios";
import { WorldInterface } from "../Interfaces/WorldInterface";




//World APIs//////////////////////////////////////////////
//Get all worlds
export const getWorlds = async (): Promise<WorldInterface[]> => {
        const response = await fetch('http://localhost:8080/worlds');
        const data = await response.json();
        return data;
}
    
//Get world by id
export const getWorld = async (id: number): Promise<WorldInterface> => {
    const response = await fetch(`http://localhost:8080/worlds/${id}`);
    const data = await response.json();
    return data;
}

