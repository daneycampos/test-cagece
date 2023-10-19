import axios from 'axios';
import React, { useState } from 'react';
import './App.css';

function SubstituirEmpregado() {
  const [employeeToReplace, setEmployeeToReplace] = useState('');
  const [substituteEmployee, setSubstituteEmployee] = useState('');
  const [prazo, setPrazo] = useState('');

  const handlerEnviar = () => {
    const formData = {
      codEmpSubstituido: employeeToReplace,
      codEmpSubstituto: substituteEmployee,
      prazo: prazo ,
    };

    axios.post('http://localhost:8080/api/solicitacoes', formData)
      .then(response => {
        console.log('Dados salvos com sucesso:', response.data);
        setEmployeeToReplace('');
        setSubstituteEmployee('');
        setPrazo('');
      })
      .catch(error => {
        console.error('Erro ao salvar os dados:', error);
      });
  }

  return (
    <div className="login-container">
      <h2>Substituir Empregado</h2>
      <div className="input-container">
        <input
          type="text"
          placeholder="Empregado a Substituir"
          value={employeeToReplace}
          onChange={(e) => setEmployeeToReplace(e.target.value)}
        />
      </div>
      <div className="input-container">
        <input
          type="text"
          placeholder="Empregado Substituto"
          value={substituteEmployee}
          onChange={(e) => setSubstituteEmployee(e.target.value)}
        />
      </div>
      
      <div className="input-container">
        <input
          placeholder="Prazo (em dias)"
          value={prazo}
          type="number"
          onChange={(e) => setPrazo(e.target.value)}
        />
      </div>
      <button onClick={handlerEnviar}>Enviar</button>
    </div>
  );
}

export default SubstituirEmpregado; 
