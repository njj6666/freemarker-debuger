<#escape x as x?json_string>
{   
        "entity": {
        	"id": "${id}",
        	"datacenter": "${request.datacenter}",
        	"eao_description": "${request.parameters.eao_description}",
   	 		<#list response.tasks as task>
        	"${task_index + 1}": "${task.name}",
    		</#list>
        }   
}
</#escape>