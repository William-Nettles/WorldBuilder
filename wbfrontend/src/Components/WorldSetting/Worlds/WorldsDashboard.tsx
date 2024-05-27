import { useState } from "react";
import { WorldInterface } from "../../../Interfaces/WorldInterface";
import { WorldCard } from "./WorldCard";

export const WorldsDashboard: React.FC = () => {

    const [worlds, setWorlds] = useState<WorldInterface[]>([]);

    return (
        <div>
        <h1>WorldsDashboard</h1>
            <p>Welcome to the WorldsDashboard page</p>

            {worlds.map(world => {
                return (
                    <div key={world.id}>
                        <img src={world.image} alt="world" />
                        <h3>{world.name}</h3>
                        <p>{world.description}</p>
                        <p>{world.user?.username}</p>
                        <WorldCard {...world} />
                    </div>
                );
            })}
        </div>
    );
}