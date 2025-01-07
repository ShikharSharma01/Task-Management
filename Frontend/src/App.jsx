import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import SignUp from './SignUp';
import Home from './Home';
import Navbar from './Navbar';
import SignIn from './SignIn';

function App() {
  

  return (
    <>
      <Router>
        <Navbar/>
      <Routes>
        <Route path='/' element={<Home/>} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/signin" element={<SignIn />} />
    </Routes>
        </Router> 
    </>
  )
}

export default App
