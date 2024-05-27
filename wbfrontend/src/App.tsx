import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Home } from './Components/Landing/Home';
import { Login } from './Components/Authorization/Login';
import { About } from './Components/Landing/About';
import { Register } from './Components/Authorization/Register';
import { Layout } from './Components/Layout/Layout';

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
            <Route path= '/worlds' element= 'WorldsDashboard' />
            <Route path='/account'element= 'UserInfo' />
          </Route>
        </Routes>      
      </BrowserRouter>

  
  
    </div>
  );
}

export default App;
