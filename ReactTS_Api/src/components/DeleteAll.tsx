import React from 'react'
import { useState, useEffect } from "react";


export const DeleteAll = () => {
    const [deleteAll, setDeleteAll] = useState<boolean>(false);

    const handleDelete = () => {
        setDeleteAll(true);
    }

    useEffect(() => {
        if (deleteAll) {
            try {
                const fetchDeleteAll = async () => {
                    const deletarAll = await fetch(`http://localhost:8080/api/autor`, {
                        method: "DELETE"
                    });
                    if (deletarAll.ok) {
                        alert("Sucesso");
                        window.location.reload();
                    } else {
                        alert(`Erro`);
                    }
                }
                fetchDeleteAll();
            } catch (err) {
                console.log("Houver erro ao excluir", err);

            }
        }
    }, [deleteAll]);
    return (
        <><button onClick={() => handleDelete()}>Deletar tudo</button></>
    )
}
