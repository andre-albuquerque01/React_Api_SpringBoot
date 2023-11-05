import './App.css'
import { Adicionar } from './components/Adicionar';
import { GetAutor } from './components/GetAutor'
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Update } from './components/Update';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<GetAutor />} />
        <Route path="/adicionar" element={<Adicionar />} />
        <Route path="/update/:id" element={<Update />} />
      </Routes>
    </BrowserRouter>
  )
}
{/* <GetAutor /> */ }

export default App
