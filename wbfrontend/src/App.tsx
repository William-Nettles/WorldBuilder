import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Home } from './Components/Landing/Home';
import { Login } from './Components/Athorization/Login';
import { About } from './Components/Landing/About';
import { Register } from './Components/Athorization/Register';

function App() {
  return (
    <div className="App">
      <BrowserRouter> 
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path='/login' element={<Login />} />
          <Route path='*' element={<h1>Not Found</h1>} />
          <Route path='/register' element={<Register/>} />
        </Routes>      
      </BrowserRouter>

  
  
    </div>
  );
}

export default App;
