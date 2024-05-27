import { useParams } from "react-router-dom";
import { WorldInterface } from "../../../Interfaces/WorldInterface";


export const WorldDetails: React.FC = () => {

    
    const {worldId} = useParams();

    return (
        <div style={{backgroundImage: 'C:/Users/Willn/Documents/Projects/Personal/WorldBuilder/wbfrontend/public/worlds splash.png'}}>
        <h1>WorldDetails</h1>
            <p>Welcome to the WorldDetails page</p>
        </div>
    );
}