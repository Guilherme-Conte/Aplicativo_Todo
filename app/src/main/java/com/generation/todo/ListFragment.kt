package com.generation.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.generation.todo.adapter.TarefaAdapter
import com.generation.todo.databinding.FragmentFormBinding
import com.generation.todo.databinding.FragmentListBinding
import com.generation.todo.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentListBinding.inflate(
            layoutInflater, container, false
        )

/*
        //Gerando a listagem de tarefas com base na classe de modelo
        val listTarefas = mutableListOf(
            Tarefa(
                "Limpar a Casa",
                "Iniciar na parte da manhã",
                "Henrique",
                "2022-21-03",
                true,
                "Dia a Dia"
            ),
            Tarefa(
                "Lavar a Louça",
                "Do dia todo :^)",
                "Henrique",
                "2022-22-03",
                false,
                "Dia a Dia"
            ),
            Tarefa(
                "Ir ao Parque",
                "Me encontrar com o pessoal no metrô",
                "Henrique",
                "2022-26-03",
                false,
                "Lazer"
            )
        )

 */

        //Configurar o Adapter

        //Instaciar o adapter
        val adapter = TarefaAdapter()

        //Definir o Layout Manager da RecyclerView
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)

        //Passar o adapter criado para o recyclerTarefa
        binding.recyclerTarefa.adapter = adapter

        //Definir a lista para ter um tamanho fixo indepedente dos itens
        binding.recyclerTarefa.setHasFixedSize(true)
/*
        //Definindo quais vão ser os dados da lista
        adapter.setLista(listTarefas)

 */

        //Navegação para o Fragment de Form
        binding.floatingAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        return binding.root
    }

}