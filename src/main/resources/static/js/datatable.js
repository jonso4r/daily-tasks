$(document).ready( function () {
	    $('#task-table').DataTable({
	    	language: {
	    		search: "Procurar: ",
	    		zeroRecords: "Nenhuma atividade encontrada",
	    		info: "Mostrando _START_ de _END_ tendo um total de _TOTAL_ atividades",
	    		infoEmpty: "Mostrando _START_ de _END_ tendo um total de _TOTAL_ atividades",
	            infoFiltered: "(Filtro realizado em _MAX_ atividades)",
	    		paginate: {
	    			next: "Próximo",
	    			previous: "Anterior"
	    		}
	    	},
	    	ordering: false,
	    	lengthChange: false
	    });
});