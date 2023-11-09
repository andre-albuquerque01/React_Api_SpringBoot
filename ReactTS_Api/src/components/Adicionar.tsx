import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "../styles/Add.css"

export const Adicionar = () => {
    const [autor, setAutor] = useState({
        nome: "",
        sobrenome: "",
        telefone: "",
        email: "",
        ativo: false,
    });

    const handleChange = (e: any) => {
        const { name, value } = e.target;
        setAutor((prevAutor) => ({
            ...prevAutor,
            [name]: value,
        }));
    };

    const handleSubmit = async (e: any) => {
        e.preventDefault();

        try {
            const response = await fetch('http://localhost:8080/api/autor', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(autor),
            });

            if (response.ok) {
                alert("Sucesso");
            } else {
                alert(`Erro`);
            }
        } catch (error) {
            console.log("Fail do try" + error);
        }
    };
    return (
        <div className="formulario-container">
          <Link to="/">Voltar</Link>
          <h1>Cadastro do autor</h1>
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label>Nome:</label>
              <input
                type="text"
                name="nome"
                value={autor.nome}
                onChange={handleChange}
                id="input"
              />
            </div>
            <div className="form-group">
              <label>Sobrenome:</label>
              <input
                type="text"
                name="sobrenome"
                value={autor.sobrenome}
                onChange={handleChange}
                id="input"
              />
            </div>
            <div className="form-group">
              <label>Telefone:</label>
              <input
                type="text"
                name="telefone"
                value={autor.telefone}
                onChange={handleChange}
                id="input"
              />
            </div>
            <div className="form-group">
              <label>Email:</label>
              <input
                type="email"
                name="email"
                value={autor.email}
                onChange={handleChange}
                id="input"
              />
            </div>
            <button className="submit-button">Enviar</button>
          </form>
        </div>
      );
    };

