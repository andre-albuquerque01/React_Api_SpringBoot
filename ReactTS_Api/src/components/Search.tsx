import React, { useEffect, useState } from 'react'

export const Search = ({ search }: any) => {
    const [autores, setAutores] = useState([]);
    const pesquisa = search;



    useEffect(() => {
        fetchSearch();
    }, [])
    return (
        <div>
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

        </div>
    );
};
