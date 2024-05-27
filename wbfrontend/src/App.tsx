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

function App() {
  return (
    <div className="App">
      <BrowserRouter> 
        <Routes>
          <Route path="/" element={<Layout />}> 
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path='/login' element={<Login />} />
            <Route path='*' element={<h1>Not Found</h1>} />
            <Route path='/register' element={<Register/>} />
            <Route path= '/worlds' element= {<WorldsDashboard />} />
            <Route path='/account'element= {<UserInfo/>} />
            <Route path='/world' element= {<WorldsLayout/>}>
              <Route path='/world/:worldId' element= {<WorldDetails/>} />
              <Route path='/world/:worldId/maps' element= {<MapDashboard/>} />
              <Route path='/world/:worldId/maps/:mapId' element= {<MapDetails/>} />
              <Route path='/world/:worldId/events' element= {<EventsDashboard/>} />
              </Route>
          </Route>
        </Routes>      
      </BrowserRouter>

  
  
    </div>
  );
}

export default App;
