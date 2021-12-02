SELECT cpu_number,id,total_mem FROM host_info
GROUP BY cpu_number, id
ORDER BY cpu_number, total_mem DESC;

select host_id, AVG(host_info.total_mem-host_usage.memory_free), date_trunc('hour', host_usage.timestamp) + date_part('minute', host_usage.timestamp):: int / 5 * interval '5 min'
from host_usage
    join host_info
on host_info.id = host_usage.host_id
group by host_id, 3;


select distinct host_id,
                round5(host_usage.timestamp) as times,
                count(*) as num_data_points
from host_usage group by times, host_id having count(*) <= 3;
