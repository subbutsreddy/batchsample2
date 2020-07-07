/*--------------------------------------------------------------------------------------------------------------
This source is part of the Profinch Software Product. 
Copyright © 2019. All rights reserved. 

No part of this work may be reproduced, stored in a retrieval system, 
adopted or transmitted in any form or by any means, electronic, mechanical, 
photographic, graphic, optic recording or otherwise, translated in any language 
or computer language, without the prior written permission of Profinch Solutions Pvt Ltd. 

Profinch Solutions Pvt Ltd.
Wings of Eagles, SS Commercial Estate,
C V Raman Nagar, Bengaluru, Karnataka 560093

Modification History:
====================
Date		Version		Change Tag 		Author			Description
----------	-----------	--------------- --------------- --------------------------------------------------------
12-03-2019	19.1						Ronak Patel 	Initial Version
----------------------------------------------------------------------------------------------------------------*/

package com.profinch.finflowz.repository;

import com.profinch.finflowz.model.TransactionDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface TransactionDetailsRepo extends JpaRepository<TransactionDetails, String> {
    public List<TransactionDetails>findByDateBeforeAndStatusCode(Date date, String status);
    public void deleteByTransactionReferanceNumber(String transactionReferanceNumber);


}