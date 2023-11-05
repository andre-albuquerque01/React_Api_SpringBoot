import { useState, useEffect } from "react";
import trash from "../img/trash.png";
import editar from "../img/editar.png";
import { DeleteAll } from "./DeleteAll";
import { Link } from "react-router-dom"
import { Search } from "./Search";

export const GetAutor = () => {
    const [autores, setAutores] = useState([]);
    const [valueId, setId] = useState<string>('');
    const [search, setSearch] = useState<string>();

    // Requisição para pegar todos os dados na tela
    const fetchData = async () => {
        try {
            const requisicao = await fetch('http://localhost:8080/api/autor');
            const reqJson = await requisicao.json();
            setAutores(reqJson);
        } catch (err) {
            console.log("Apresenta erro", err);
        }
    };

    // Requisição para apagar um unico dado
    const fetchDelete = async () => {
        try {
            const deletar = await fetch(`http://localhost:8080/api/autor/${valueId}`, {
                method: "DELETE"
            });
            alert("Excluido com sucesso")
            fetchData();
        } catch (err) {
            alert("Houver erro ao excluir");
        }
    }

    // Requisição para pesquisar pelo nome
    const fetchSearch = async () => {
        try {
            const requisicao = await fetch(`http://localhost:8080/api/autor/nome?nome=${search}`);
            const reqJson = await requisicao.json();
            setAutores(reqJson);
        } catch (err) {
            setAutores({})
            console.log("Apresenta erro no search", err);
        }
    };

    // Funções para modificar ou pegar id
    const handleId = (id: String) => {
        setId(id);
    }
console.log(search);

    const handleSearch = () => {
        if (search !== '' && search !== undefined) {
            fetchSearch();
        }
    }

    const handleClear = () => {
        fetchData();
    }

    // Hook para atualizar a tela
    useEffect(() => {
        fetchData();
    }, []);

    useEffect(() => {
        if (valueId !== '') {
            fetchDelete();
        }
    }, [valueId]);

    return (
        <div>
            <div className="">
                {autores.length > 0 ? (<DeleteAll />) : ''}
                <Link to='/adicionar'>Adicionar</Link>
                <div>
                    <br /><input type="text" placeholder="Pesquisar por nome" onChange={(e) => setSearch(e.target.value)} />
                    <button onClick={handleSearch}>Pesquisar</button>
                    <button onClick={handleClear}>Limpar</button>
                </div>
                <br />
            </div>
            <table>
                <tr>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>E-mail</th>
                    <th>Telefone</th>
                    <th>#</th>
                    <th>#</th>
                </tr>

                {autores.length > 0 ? autores.map(({ id, nome, sobrenome, email, telefone }) => (
                    <tr key={id}>
                        <td>{nome}</td>
                        <td>{sobrenome}</td>
                        <td>{email}</td>
                        <td>{telefone}</td>
                        <td><img src={trash} alt="" width={15} onClick={() => handleId(id)} /></td>
                        <td><Link to={`update/${id}`}><img src={editar} alt="" width={15} /></Link></td>
                    </tr>
                )) : <td colSpan={6}>Nenhum resultado encontrado</td>}
            </table>
        </div>
    );
};
