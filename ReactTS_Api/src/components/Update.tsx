import { useState, useEffect } from "react";
import { Link, useParams } from "react-router-dom";

export const Update = () => {
    const [autor, setAutor] = useState({});
    const { id } = useParams();
    
    useEffect(() => {
        const fetchData = async () => {
            try {
                const requisicao = await fetch(`http://localhost:8080/api/autor/${id}`);
                const reqJson = await requisicao.json();
                setAutor(reqJson);
            } catch (err) {
                console.log("Apresenta erro", err);
            }
        };
        
        fetchData();
    }, []);
    
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
            const response = await fetch(`http://localhost:8080/api/autor/${id}`, {
                method: 'PUT',
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
            console.log("Fail to try" + error);
        }
    };

    return (
        <div>
            <Link to="/">Voltar</Link>
            <h1>Editar autor</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Nome:</label>
                    <input
                        type="text"
                        name="nome"
                        value={autor.nome}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Sobrenome:</label>
                    <input
                        type="text"
                        name="sobrenome"
                        value={autor.sobrenome}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Telefone:</label>
                    <input
                        type="text"
                        name="telefone"
                        value={autor.telefone}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Email:</label>
                    <input
                        type="email"
                        name="email"
                        value={autor.email}
                        onChange={handleChange}
                    />
                </div>
                <button>Enviar</button>
            </form>
        </div>
    )
}
