// import React from 'react';


import NavBar from "./components/NavBar";
import Footer from "./components/Footer";
import DataTable from "./components/DataTable";
import BarChart from "./components/BarChart"
import Donutchart from "components/DonutChart";

function App() {
    return (
        <>
            <NavBar/>
            <div className="container">
                <h1 className="text-primary py-3">Dashboard de Vendas</h1>
                <div className="row px-3">
                    <div className="col-sm-6">
                        <h5 className="text-center text-secundary">Taxa de Sucesso (%)</h5>
                        <BarChart />
                    </div>
                    <div className="col-sm-6">
                        <h5 className="text-center text-secundary">Taxa de Sucesso (%)</h5>
                        <Donutchart />
                    </div>
                </div>
                <div className="py-3">
                    <h2 className="text-primary">Total De Vendas</h2>
                </div>
                <DataTable/>
            </div>
            <Footer/>

        </>
    );
}

export default App;
