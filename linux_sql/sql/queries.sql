SELECT cpu_number,id,total_mem
FROM host_info
GROUP BY cpu_number, id
ORDER BY cpu_number, total_mem DESC;

SELECT
    host_id, hostname,
    (AVG(host_info.total_mem-host_usage.memory_free * 1000)/host_info.total_mem) * 100 as mem_percent_used,
    round5(host_usage.timestamp)
FROM host_usage
         JOIN host_info
              ON host_info.id = host_usage.host_id
GROUP BY host_usage.timestamp, host_id, hostname, total_mem;


select distinct host_id,
                round5(host_usage.timestamp) as times,
                count(*) as num_data_points
from host_usage group by times, host_id having count(*) <= 3;
