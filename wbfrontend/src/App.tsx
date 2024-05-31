import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Home } from './Components/Landing/Home';
import { Login } from './Components/Authorization/Login';
import { About } from './Components/Landing/About';
import { Register } from './Components/Authorization/Register';
import { Layout } from './Components/Layout/Layout';
import { WorldsDashboard } from './Components/WorldSetting/Worlds/WorldsDashboard';
import { UserInfo } from './Components/Users/UserInfo';
import { WorldsLayout } from './Components/Layout/WorldsLayout';
import { WorldDetails } from './Components/WorldSetting/Worlds/WorldDetails';
import { MapDetails } from './Components/WorldSetting/Maps/MapDetails';
import { MapDashboard } from './Components/WorldSetting/Maps/MapDashboard';
import { EventsDashboard } from './Components/WorldSetting/WorldEvents/EventsDashboard';
import { CharacterDashboard } from './Components/People/Characters/CharacterDashboard';
import { LocationDashboard } from './Components/WorldSetting/Locations/LocationDashboard';
import { FactionDashboard } from './Components/People/Factions/FactionDashboard';
import { EventDetails } from './Components/WorldSetting/WorldEvents/EventDetails';
import { CharacterDetails } from './Components/People/Characters/CharacterDetails';
import { LocationDetails } from './Components/WorldSetting/Locations/LocationDetails';
import { FactionDetails } from './Components/People/Factions/FactionDetails';
import { BuildWorld } from './Components/Builders/BuildWorld';
import { BuildCharacter } from './Components/Builders/BuildCharacter';

function App() {
  return (
    <div className="App" style={{ }}>
      <BrowserRouter> 
        <Routes>
          <Route path="/" element={<Layout />}> 
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path='/login' element={<Login />} />
            <Route path='*' element={<h1>Not Found</h1>} />
            <Route path='/register' element={<Register/>} />
            <Route path= '/worlds' element= {<WorldsDashboard />} />
            <Route path='/worlds/add' element = {<BuildWorld/>} />
            <Route path='/characters/add' element = {<BuildCharacter/>} />
            <Route path='/account'element= {<UserInfo/>} />
            <Route path='/world' element= {<WorldsLayout/>}>
              <Route path='/world/:worldId' element= {<WorldDetails/>} />
              <Route path='/world/:worldId/maps' element= {<MapDashboard/>} />
              <Route path='/world/:worldId/maps/:mapId' element= {<MapDetails/>} />
              <Route path='/world/:worldId/events' element= {<EventsDashboard/>} />
              <Route path='/world/:worldId/characters' element= {<CharacterDashboard/>} />
              <Route path='/world/:worldId/locations' element={<LocationDashboard/>} />
              <Route path='/world/:worldId/factions' element={<FactionDashboard/>}/>
              <Route path='/world/:worldId/events/:eventId' element= {<EventDetails/>} />
              <Route path='/world/:worldId/characters/:characterId' element= {<CharacterDetails/>} />
              <Route path='/world/:worldId/locations/:locationId' element={<LocationDetails/>} />
              <Route path='/world/:worldId/factions:factionId/' element={<FactionDetails/>}/>
              </Route>
          </Route>
        </Routes>      
      </BrowserRouter>

  
  
    </div>
  );
}

export default App;
