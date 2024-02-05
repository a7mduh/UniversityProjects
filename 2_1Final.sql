------------------------------------2.1.1------------------------------------------------------
select *
from detectives;
select *
from crime_cases;
select *
from evidence;
select *
from suspects;
select *
from case_suspects;
------------------------------------2.1.2------------------------------------------------------
select*
from crime_cases
where status='unsolved';


------------------------------------2.1.3------------------------------------------------------
select *
from evidence
where case_id IN (
    select case_id
    from crime_cases
    where status='unsolved') and location_found like '%crime%';
------------------------------------2.1.4------------------------------------------------------
select distinct suspects.*
from suspects, evidence, case_suspects
where criminal_record='yes' and suspects.suspect_id in (select suspect_id
from crime_cases, case_suspects
where status='unsolved' and crime_cases.case_id=case_suspects.case_id);
------------------------------------2.1.5------------------------------------------------------
--In this query, we followed the instructions given by Dr. Nouf that we need to retrieve the suspects whose alibi is No alibi or At home
select *
from case_suspects
where (alibi='No alibi' or alibi='At home') and case_id=1;

------------------------------------2.1.6------------------------------------------------------
--In this query, we followed the instructions given by dr. Nouf that all the tables provided are recent.
select evidence.*
from evidence
where evidence.evidence_id in(SELECT evidence.evidence_id
FROM case_suspects
LEFT JOIN evidence
ON evidence.case_id = case_suspects.case_id 
group by evidence.evidence_id
having count(*)>1);

------------------------------------2.1.7------------------------------------------------------
select suspects.suspect_id,suspects.name,suspects.criminal_record
from evidence, suspects, case_suspects
where evidence.location_found like '%crime%' and evidence.description='Fingerprint' and evidence.case_id=case_suspects.case_id and suspects.criminal_record='yes' and suspects.suspect_id=case_suspects.suspect_id ;

------------------------------------2.1.8------------------------------------------------------
--In this query, we followed the instructions given by dr. Nouf that all the evidences are recent.
select distinct suspects.suspect_id, suspects.name, case_suspects.alibi
from suspects, case_suspects
where case_suspects.alibi='No alibi' and case_suspects.suspect_id=suspects.suspect_id;
------------------------------------2.1.9------------------------------------------------------
select *
from suspects
where suspect_id=1;