import { WorldInterface } from "../../../Interfaces/WorldInterface";

export const WorldCard: React.FC<WorldInterface> = (world: WorldInterface) => {
    return (
        <div className="world-card">
            <img src={world.image} alt="world" />
            <h3>{world.name}</h3>
            <p>{world.description}</p>
            <p>{world.user?.username}</p>
        </div>
    );
}