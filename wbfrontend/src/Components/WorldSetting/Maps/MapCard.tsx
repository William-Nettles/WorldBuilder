import { MapInterface } from "../../../Interfaces/MapInterface";

export const MapCard: React.FC<MapInterface> = (map: MapInterface) => {
    return (
        <div className="map-card">
            <img src={map.image} alt="map" />
            <h3>{map.name}</h3>
            <p>{map.description}</p>
        </div>
    );
}